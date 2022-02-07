import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";


class FooterComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            
        }
    }
    
    render() {
        return (
            <div>
                <footer className="footer">
                   <span className="text-muted">All Right Reserved</span>
                </footer>
            </div>
        )
    }
}

export default FooterComponent;