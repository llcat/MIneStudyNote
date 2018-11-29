import React, { Component } from 'react'

class Api extends Component {

    // constructor(props){
    //     super(props)
    //     this.state = {
    //         data:[]
    //     }
    // }
    state = {
        data:[]
    }
    componentDidMount() {
        const url = "https://en.wikipedia.org/w/api.php?action=opensearch&search=Math&format=json&origin=*"
        fetch(url)
            .then(result => result.json())
            .then(result => {
                this.setState({
                    data:result
                })
            })
    }

    render(){
        const { data } = this.state
        const result = []
        if(data.length>0){
            data[1].forEach((e,i)=>{
                let l = <li key={i}><a href={data[3][i]}>{e}</a><p>{data[2][i]}</p></li>
                result.push(l)
            })
        }
        return <div><h4>{data[0]}</h4><ul>{result}</ul></div>
    }
}

class Api1 extends Component {
    state = {
        data: []
    };

    // Code is invoked after the component is mounted/inserted into the DOM tree.
    componentDidMount() {
        const url = "https://en.wikipedia.org/w/api.php?action=opensearch&search=Seona+Dancing&format=json&origin=*";

        fetch(url)
            .then(result => result.json())
            .then(result => {
                this.setState({
                    data: result
                })
            });
    }

    render() {
        const { data } = this.state;

        const result = data.map((entry, index) => {
            return <li key={index}>{entry}</li>;
        });

        return <ul>{result}</ul>;
    }
}
export default Api;