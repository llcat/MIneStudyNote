import React from 'react';
import LoginForm from './LoginForm';
import TopHeader from './TopHeader';
import OperateMenu from './OperateMenu'
import { Route, Switch } from 'react-router-dom'
import { Layout } from 'antd'
import FileUpLoader from './FileUpLoader'
import VideoGallery from './VideoGallery'
import Welcome from './Welcome'
import './App.css';


const { Content } = Layout

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            userInfo: {}
        }
        this.onLoginFormSubmit = this.onLoginFormSubmit.bind(this)
        this.onUserLogOut = this.onUserLogOut.bind(this)
    }

    onLoginFormSubmit(userInfo){

        this.setState({
            userInfo: userInfo
        })
    }

    onUserLogOut(){
        this.setState({
            userInfo: {}
        })
    }

    render() {
        return (
            <div className="app">
                <Route path="/" render={(props) => {
                    return (
                        <TopHeader 
                            {...props} 
                            userInfo={this.state.userInfo}
                            onUserLogOut={this.onUserLogOut}
                        />
                    )
                }}
                />
                <Route path="/login" render={(props) => (
                    <LoginForm 
                    {...props} 
                    onLoginFormSubmit={this.onLoginFormSubmit} 
                    />
                )} />
                <Route path="/home" render={(props) => (
                    <div className="main-container">
                        <Layout>
                            <OperateMenu {...props} />
                            <Content style={{margin:"0 2vw"}}>
                                <Switch>
                                    <Route path={props.match.url+"/gallery"} component={VideoGallery} />
                                    <Route path={props.match.url+"/upload"} component={FileUpLoader} />
                                    <Route component={Welcome} />
                                </Switch>
                            </Content>
                        </Layout>
                    </div>
                )} />
            </div>  
        );
    }

}

export default App;

