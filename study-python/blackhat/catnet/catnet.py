"""
    catnet.py
    based on python 3.7
    a simple tool mock netcat
    author: Pino Yu
"""

import sys
import socket
import getopt
import threading
import subprocess
import time

listen = False
command = False
upload = False
execute = ""
target = ""
upload_destination = ""
port = 0

def usage():
    tooltips = '''
    Cat Net Tool
    
    Usage: catnet.py -t target_host -p port
    -l --listen                listen on [host]:[port] for
                               incoming connections
    -e --execute=file_to_run   execute the given file upon
                               receiving a connection
    -c --command               initialize a command shell
    -u --upload=destination    upon receiving connection upload a
                               file and write to [destination]
    
    
    Examples:
    catnet.py -t 192.168.0.1 -p 5555 -l -c
    catnet.py -t 192.168.0.1 -p 5555 -l -u=c:\\target.exe
    catnet.py -t 192.168.0.1 -p 5555 -l -e=\"cat /etc/passwd\"
    echo \'ABCDEFGHI\' | ./catnet.py -t 192.168.11.12 -p 135    
    '''
    print(tooltips)
    sys.exit(0)

def main():
    global listen
    global port
    global execute
    global command
    global upload_destination
    global target

    if not len(sys.argv[1:]):
        usage()

    try:
        # short_opts
        # -h  -> h
        # -p 5555 -> p:
        # long_opts
        # --port 5555 OR --port=5555 -> ["port="]
        opts, args = getopt.getopt(sys.argv[1:],"hle:t:p:cu",["help","listen","execute=","target=","port=","command","upload"])

    except getopt.GetoptError as err:
        print(err)
        usage()

    for opt, val in opts:
        if opt in ("-h", "--help"):
            usage()
        elif opt in ("-l", "--listen"):
            listen = True
        elif opt in ("-e", "--execute"):
            execute = val
        elif opt in ("-c", "--command"):
            command = True
        elif opt in ("-u", "--upload"):
            upload_destination = val
        elif opt in ("-t", "--target"):
            target = val
        elif opt in ("-p", "--port"):
            port = int(val)
        else:
            assert False, "Unhandled Option"

    if not listen and len(target) and port > 0:

        buffer = sys.stdin.read()
        print(type(buffer), len(buffer))
        client_sender(buffer)

    if listen:
        server_loop()


def client_sender(buffer):
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        client.connect((target, port))
        if len(buffer):
            print("client_sender:",len(buffer))
            client.send(buffer)

        while True:
            recv_len = 1
            response = ""

            while recv_len:
                data = client.recv(4096)
                recv_len = len(data)
                print("recv_len:",recv_len)
                print(type(data), str(data))
                response += str(data)

                if recv_len < 4096:
                    break
            print(len(response))
            print(response)

            buffer = input(">>>")
            buffer += "\n"
            print("input_cmd:",buffer, type(buffer), len(buffer))
            client.send(bytes(buffer, "utf8"))
    except Exception as e:
        print("[*] Exception Existing.")
        print(e)
        client.close()

def server_loop():
    global target

    if not len(target):
        target = "0.0.0.0"

    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    server.bind((target, port))

    server.listen(5)

    while True:
        client_socket, addr = server.accept()
        print(addr)
        client_thread = threading.Thread(target=client_handler, args=(client_socket,))
        client_thread.start()

def run_command(command):
    print("start run command")
    command = command.rstrip()
    try:
        output = subprocess.check_output(command, stderr=subprocess.STDOUT, shell=True)
    except:
        output = "Failed to execute command.\r\n"

    return output

def client_handler(client_socket):
    global upload
    global execute
    global command

    if len(upload_destination):
        file_buffer = ""

        while True:
            data = client_socket.recv(1024)

            if not data:
                break
            else:
                file_buffer += data

        try:
            file_descriptor = open(upload_destination, 'wb')
            file_descriptor.write(file_buffer)
            file_descriptor.close()

            client_socket.send("Successfully saved file to ", upload_destination)
        except:
            client_socket.send("Failed to save file to ", upload_destination)

    if len(execute):
        output = run_command(execute)
        client_socket.send(output)

    if command:
        while True:
            client_socket.send(b"<CAT:#> ")
            cmd_buffer = ""
            time.sleep(3)
            while "\n" not in cmd_buffer:
                print("start recv cmd")
                data = client_socket.recv(1024)
                time.sleep(3)
                print("cmd data:",data, type(data), len(data))
                cmd_buffer += str(data,"utf8")
                print(cmd_buffer)

            print("exit while",cmd_buffer)
            response = run_command(cmd_buffer)
            client_socket.send(response)


if __name__ == "__main__":
    main()