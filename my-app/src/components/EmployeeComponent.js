import React from 'react';
import EmployeeService from "../services/EmployeeService";


class EmployeeComponent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            employees: []
        };
    }

    componentDidMount() {
        EmployeeService.getEmployees().then((response) => {
            this.setState({employees: response.data})
        })
    }

    render() {
        return (
            <div>
                <h1 className="text-center"> Employees List</h1>
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <td>Employee Id</td>
                        <td>Employee First Name</td>
                        <td>Employee Last Name</td>
                        <td>Employee Role</td>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.employees.map(
                            employee => (
                                <tr key={employee.id}>
                                    <td> {employee.id}</td>
                                    <td> {employee.firstName}</td>
                                    <td> {employee.lastName}</td>
                                    <td> {employee.name}</td>
                                    <td> {employee.role}</td>
                                </tr>
                        ))
                    }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default EmployeeComponent;
