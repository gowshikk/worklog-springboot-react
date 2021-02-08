import React, { Component } from "react";
import axios from "axios";

class LoginPage extends Component {

  constructor(props) {
    super(props);
    this.state = {
      username: "admin",
      password: "admin",
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }


  handleFormSubmit = event => {
    event.preventDefault();

    const endpoint = "http://localhost:8888/worklog/jwt/login";

    const username = this.state.username;
    const password = this.state.password;

    const user = {
      username: username,
      password: password
    };

    axios.post(endpoint, user).then(res => {
      localStorage.setItem("authorization", res.data);
      console.log(res.data + "  --->from local " + localStorage.getItem("authorization"))
      return this.handleDashboard();
      //this.props.history.push("/dashboard");
    }).catch((error)=>{
      console.log(error);
      alert("Wrong IDs");
    });
  };

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    })
  }

  handleDashboard() {
    axios.post("http://localhost:8080/jwt/validate", {}, {
      headers: {
        Authorization: 'Bearer ' + localStorage.getItem("authorization")
      }
    }).then(res => {
      if (res.data === this.state.username) {
        console.log("Validated--->" + res.data)
        localStorage.setItem("username",res.data)
        console.log("Local Storage Username--->" + localStorage.getItem("username"))
        this.props.isLoggedInHandler(res.data);
        this.props.history.push({
          pathname: '/dashboard',
          state: {
            username: res.data,
            token: localStorage.getItem("authorization")
          }
        });
      } else {
        alert("Authentication failure");
      }
    }).catch((error) => {
      alert("Wrong JWT token");
    });
  }

  render() {
    return (
      <div>
        <div className="wrapper">
          <form className="form-signin" onSubmit={this.handleFormSubmit}>
            <h2 className="form-signin-heading">Please login</h2>
            <div className="form-group">
              <input type="text"
                className="form-control"
                name="username"
                placeholder="User name"
                value={this.state.username} onChange={this.handleChange}
              />
            </div>
            <div className="form-group">
              <input type="password"
                name="password"
                className="form-control"
                placeholder="password"
                value={this.state.password} onChange={this.handleChange}
              />
            </div>
            <button className="btn btn-lg btn-primary btn-block" type="submit">
              Login
            </button>
          </form>
        </div>
      </div>
    );
  }
}
export default LoginPage;