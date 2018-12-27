import React from 'react';
import LoginForm from './LoginForm';
import TopHeader from './TopHeader';
import OperateMenu from './OperateMenu'
import { BrowserRouter as Router, Route } from 'react-router-dom'
import { Layout } from 'antd'
import FileUpLoader from './FileUpLoader'
import VideoGallery from './VideoGallery'
import './App.css';


const { Content } = Layout

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
                    <Route path="/home" exact render={(props) => (
                        <div className="main-container">
                            <Layout>
                                <OperateMenu />
                                <Content style={{margin:"0 2vw"}}>
                                    <VideoGallery />
                                    <Route path={props.match.url+"/upload"} component={FileUpLoader} />
                                </Content>
                            </Layout>
                        </div>
                    )} />
                </div>
            </Router>
        );
    }

}

export default App;

