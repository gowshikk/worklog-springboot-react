import React, { Component } from 'react'
import "./CSS/Login.css";
import axios from "axios";

export class WorkLogForm extends Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            position: '',
            project: '',
            log: '',
            hours: '',
            date: new Date().toISOString(),
            errormessage: ''

        }
        this.onSubmit = this.onSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
        this.resetState = this.resetState.bind(this);
    }


    resetState() {
        this.setState({
            name: '',
            position: '',
            project: '',
            logDetails: [{
                log: '',
                hours: '',
                date: new Date().toISOString()
            }]
        })
        alert("Added Log");
        this.props.history.push({
            pathname: '/dashboard',
            state: {
              username: this.props.username,
              token: localStorage.getItem("authorization")
            }
          });
    }

    onSubmit = e => {
        e.preventDefault();

        const name = this.state.name;
        const project = this.state.project;
        const position = this.state.position;
        const logDetails = [{
            log: this.state.log,
            hours: this.state.hours,
            date: new Date().toISOString()
        }]

        axios.post(`http://localhost:8081/worklog/saveForm`, { name, project, position, logDetails })
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
        this.resetState()
    };

    onChange = (e) => {
        console.log(e.target)
        let name = e.target.name;
        let value = e.target.value;
        const format = /[!@#$%^&*()_+\-=[\]{};':"\\|,.<>/?]+/;
        if (name === "name") {
            let errormsg = '';
            if (value !== "" && Number(value)) {
                errormsg = <strong>Your Name should not start with a number</strong>;
                this.setState({ errormessage: errormsg });
            }
            if (format.test(value)) {
                errormsg = <strong>Your Name should not contains special characters</strong>;
                this.setState({ errormessage: errormsg });
            }
        }
        this.setState({ [e.target.name]: e.target.value })
    }

    onChangeLog = (e) => {
        console.log(e.target)
        this.setState({
            logDetails: {
                [e.target.name]: e.target.value
            }
        })
    }

    render() {
        return (
            <div>
                <h3>Hello {this.props.username}</h3>
                <form onSubmit={this.onSubmit} style={{ textAlign: 'center' }}>
                    <h2 className='text-primary'>Add Log</h2>
                    <div className="form-group">
                        <label >Enter the Name:</label>
                        <input
                            type='text'
                            placeholder='Name'
                            className="form-control"
                            name='name'
                            value={this.state.name}
                            onChange={this.onChange}
                        />
                    </div>
                    <div className="form-group">
                        <label >Select the position</label>
                        <select
                            placeholder='Position'
                            className="form-control"
                            name='position'
                            onChange={this.onChange}
                            value={this.state.position}
                        >
                            <option value="none">None</option>
                            <option value="PAT">PAT</option>
                            <option value="Associate">Associate</option>
                            <option value="SR.Associate">SR.Associate</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label >Select the project:</label>
                        <select
                            placeholder='Project'
                            className="form-control"
                            name='project'
                            onChange={this.onChange}
                            value={this.state.project}
                        >
                            <option value="none">None</option>
                            <option value="Met life">Met Life</option>
                            <option value="GSSP">GSSP</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label >Enter the Log:</label>
                        <textarea rows="5" cols="30"
                            placeholder='Enter Log description'
                            className="form-control"
                            name='log'
                            value={this.state.log}
                            onChange={this.onChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Enter the No of hours:</label>
                        <input
                            type='text'
                            placeholder='Enter No of Hours'
                            className="form-control"
                            name='hours'
                            value={this.state.hours}
                            onChange={this.onChange}
                        />
                    </div>

                    <input
                        type='submit'
                        value="Add"
                        className='btn btn-primary btn'
                    />
                </form>
            </div>
        );
    }
}

export default WorkLogForm;