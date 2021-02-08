import React from 'react';
import { Card, CardDeck } from 'react-bootstrap'
import axios from 'axios';


class GetLog extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
            access: false,
        };
    };
    componentDidMount() {
        console.log("Mounting....");
        axios.get(`http://localhost:8888/getlog/worklog/list`)
            .then(res => {
                console.log(res.data);
                const data = res.data;
                this.setState({ data: data });
            })
    }


    render() {
        const username = (this.props.location.state) ? this.props.location.state.username : this.props.username;
        const logData = (username === "admin") ? this.state.data.map((log, index) => {
            return ( <div key={index}>
                <Card style={{ width: '18rem' }}>
                    <Card.Body>
                        <Card.Title>{log.name}</Card.Title>
                        <Card.Subtitle className="mb-2 text-muted"><strong>Position:</strong>{log.position}</Card.Subtitle>
                        <Card.Text><strong>Project: </strong>{log.project}</Card.Text>
                        {log.logDetails.map((inner, i) => {
                            return (
                                <span key={i}>
                                    <Card.Text><strong>LOG: </strong>{inner.log}</Card.Text>
                                    <Card.Text><strong>Hours Spent: </strong>{inner.hours}</Card.Text>
                                    <Card.Text><strong>Date: </strong>{inner.date}</Card.Text>
                                </span>
                            )
                        })}
                        {/* <Link to="/toshowLog">Show Log</Link> */}
                    </Card.Body>
                </Card>
                <br />
            </div> 
            )
        }) : this.state.data.map((log, index) => {
            return ((log.name.toUpperCase() === username.toUpperCase()) ? <div key={index}>
                <Card style={{ width: '18rem' }}>
                    <Card.Body>
                        <Card.Title>{log.name}</Card.Title>
                        <Card.Subtitle className="mb-2 text-muted"><strong>Position:</strong>{log.position}</Card.Subtitle>
                        <Card.Text><strong>Project: </strong>{log.project}</Card.Text>
                        {log.logDetails.map((inner, i) => {
                            return (
                                <span key={i}>
                                    <Card.Text><strong>LOG: </strong>{inner.log}</Card.Text>
                                    <Card.Text><strong>Hours Spent: </strong>{inner.hours}</Card.Text>
                                    <Card.Text><strong>Date: </strong>{inner.date}</Card.Text>
                                </span>
                            )
                        })}
                        {/* <Link to="/toshowLog">Show Log</Link> */}
                    </Card.Body>
                </Card>
                <br />
            </div> : ''
            )
        });

        //let username = (this.props.location.state) ? this.props.location.state.username : '';
        return (
            <div>
                {/* <h2>Here is your Logs {username} </h2> */}
                <br />
                <CardDeck>
                    {logData}
                </CardDeck>
            </div>
        );
    }
}

export default GetLog;