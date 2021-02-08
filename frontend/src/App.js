import React, { Fragment } from 'react';
import Header from './components/Header';
import LoginPage from './components/LoginPage';
import Dashboard from './components/Dashboard';
import { BrowserRouter as Router, Redirect, Route, Switch } from 'react-router-dom';
import './App.css';
import WorkLogForm from './components/WorkLogForm';
import GetLog from './components/GetLog';

class App extends React.Component {

  constructor(props)
  {
    super(props);
    this.state={
      isloggedIn : false,
      username:''
    }
    this.isloggedInHandler = this.isloggedInHandler.bind(this)
  }

  isloggedInHandler(username)
  {
    this.setState({
      isloggedIn:true,
      username:username
    })

  }

  render() {
    return (
      <div className="App">
        <Router >
          <Fragment>
            <Header />
            <div className="container">
              <Switch>
                <Route exact path="/" render={(props) =>{ (this.state.isloggedIn) ? <Dashboard username={this.state.username} {...props}/> : <Redirect to = "/login" /> } } /> 
                <Route exact path="/login" render={(props) => <LoginPage isLoggedInHandler = {this.isloggedInHandler} {...props}/>} />
                <Route exact path="/dashboard" render={(props) => <Dashboard username={this.state.username} {...props}/>} />
                <Route exact path="/logform" render={(props) => <WorkLogForm username={this.state.username} {...props}/>} />
                <Route exact path="/getlog" render={(props) => <GetLog username={this.state.username} {...props}/>} />
              </Switch>
            </div>
          </Fragment>
        </Router>
      </div>
    );
  }

}
//export default withRouter(App);
export default App;
