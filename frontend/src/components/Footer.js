import React from "react";


class Footer extends React.Component {
    render() {
        const styles = {
            textAlign: 'left',
            bottom: 0,
            width: "100%",
            color: 'Black',
            position: 'fixed'
        }
        return (
        
            <div style={styles} className="footer bg-light">
            <p>Footer </p>
          </div>);
    }

}

export default Footer;