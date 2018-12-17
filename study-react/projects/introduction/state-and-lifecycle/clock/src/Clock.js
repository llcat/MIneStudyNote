import React, { Component } from 'react'

class Clock extends Component {

    constructor(props) {
        super(props);
        this.state = {
            date: new Date()
        };
    }

    componentDidMount() {
        this.timerID = setInterval(
            () => this.tick(),
            1000
        );
    }

    componentWillUmount() {
        clearInterval(this.timerID);
    }

    tick() {
        this.setState({
            date: new Date()
        })
    }

    render() {
        const { date } = this.state
        return (
            <div>
                <h1>Hello World!</h1>
                <h2>It is {date.toLocaleTimeString()}</h2>
            </div>
        )
    }

}

export default Clock;