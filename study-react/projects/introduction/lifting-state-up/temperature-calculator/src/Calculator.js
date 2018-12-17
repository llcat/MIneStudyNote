import React, { Component } from 'react'

const scaleNames = {
    c: 'Celsius',
    f: 'Fahrenheit'
}

function toCelsius(fahrenheit) {
    return (fahrenheit -32) *5 / 9;
}

function toFahrenHeit(celsius) {
    return (celsius * 9 / 5) + 32;
}

function tryConvert(temperature, convert) {
    const input = parseFloat(temperature);
    if(Number.isNaN(input)){
        return ""
    }
    const output = convert(temperature);
    const rounded = Math.round(output * 1000) / 1000;
    return rounded.toString();
}

const BoilingVerdict = (props) => {
    if(props.celsius >= 100){
        return <p>the water would boil</p>
    }
    return <p>the water would not biol</p>
}

class TemperatureInput extends Component {
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(e) {
        this.props.onTemperatureChange(e.target.value)
    }

    render() {
        const temperature = this.props.temperature;
        const scale = this.props.scale;
        return (
            <fieldset>
                <legend>
                    Enter Temperature in {scaleNames[scale]}.
                </legend>
                <input value={temperature} onChange={this.handleChange} />
            </fieldset>
        );
    }
}

class Calculator extends Component {
    constructor(props) {
        super(props);
        this.handleCelsiusChange = this.handleCelsiusChange.bind(this);
        this.handleFahrenheitChange = this.handleFahrenheitChange.bind(this);
        this.state = {
            scale: 'c',
            temperature: ""
        };
    }

    handleCelsiusChange(temperature) {
        this.setState({
            scale: 'c',
            temperature: temperature
        });
    }

    handleFahrenheitChange(temperature) {
        this.setState({
            scale: 'f',
            temperature: temperature
        })
    }

    render() {
        const scale = this.state.scale;
        const temperature = this.state.temperature;
        const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature;
        const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenHeit) : temperature
        return (
            <div>
                <TemperatureInput 
                  scale="c"
                  temperature={celsius} 
                  onTemperatureChange={this.handleCelsiusChange} />
                <TemperatureInput 
                  scale="f"
                  temperature={fahrenheit} 
                  onTemperatureChange={this.handleFahrenheitChange} />
                <BoilingVerdict celsius={parseFloat(celsius)} /> 
            </div>
        );
    }
}

export default Calculator;