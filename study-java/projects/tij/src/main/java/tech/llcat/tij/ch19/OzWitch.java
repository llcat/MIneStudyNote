package tech.llcat.tij.ch19;

public enum OzWitch {
    // enum 可以给自身增加额外的信息和方法，这点与类并无不同。
    WEST("Miss Gulch"),
    NORTH("Glinda"),
    EAST("Wicked Witch"),
    SOUTH("Good by inference");

    String description;
    OzWitch(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public static void main(String[] args) {
        for(OzWitch witch: OzWitch.values()){
            System.out.println(witch +":"+witch.getDescription());
        }
    }
}
