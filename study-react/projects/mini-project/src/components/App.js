import React from 'react';
import LoginForm from './LoginForm';
import './App.css';
import TopHeader from './TopHeader';
import { BrowserRouter as Router, Route } from 'react-router-dom'

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userName: ""
        }
        this.onLoginFormSubmit = this.onLoginFormSubmit.bind(this)
        this.onUserLogOut = this.onUserLogOut.bind(this)
    }

    onLoginFormSubmit(userInfo){
        this.setState({
            userName: userInfo.userName
        })
    }

    onUserLogOut(){
        this.setState({
            userName: ""
        })
    }

    render() {
        console.log(this.props)
        return (
            <Router>
                <div className="app">
                    <Route path="/" render={(props) => {
                        return (
                            <TopHeader 
                              {...props} 
                              userName={this.state.userName}
                              onUserLogOut={this.onUserLogOut}
                            />
                        )
                    }}
                    />
                    <Route path="/login" render={(props) => (
                        <div className="form-container">
                            <LoginForm 
                              {...props} 
                              onLoginFormSubmit={this.onLoginFormSubmit} 
                            />
                        </div>
                    )} />
                    <Route path="/home" render={() => (
                        <div className="main-container">
                            test
                        </div>
                    )} />
                </div>
            </Router>
        );
    }

}

export default App;

