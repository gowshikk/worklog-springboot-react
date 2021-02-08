import React from 'react';
import { Redirect } from 'react-router-dom';

class Dashboard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
 
            isGetLogClicked: false
        }
        this.handleGetLog = this.handleGetLog.bind(this)
    }
    handleLogout() {
        localStorage.clear();
        window.location.href = "/login";
    }

    handleGetLog() {
        this.setState({
            isGetLogClicked: true
        });
    }

    componentDidMount() {
        let username = (this.props.location.state) ? this.props.location.state.username : '';
        console.log("Mounting Dashboard... with username  " + username)
    }

    render() {
        let username = ( this.props.location.state) ? this.props.location.state.username : '';

        return (
            < div >
                <h1>WELCOME TO DASHBOARD {username}</h1>

                <button onClick={this.handleLogout}
                    className="btn">
                    <i className="ti-power-off mR-10"></i>
                    <span style={{ color: "Black" }}>Logout</span>
                </button>
                {(this.state.isGetLogClicked) ? <Redirect
                    to={{
                        pathname: "/getlog",
                        state: { username: username }
                    }}
                /> :
                    <button onClick={this.handleGetLog}
                        className="btn">
                        <i className="ti-power-off mR-10"></i>
                        <span style={{ color: "Black" }}>Getlog</span>
                    </button>}

            </div >
        );
    }

}

export default Dashboard;