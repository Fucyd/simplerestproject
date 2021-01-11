import axios from 'axios';

const EMPLOYEE_API_URL = 'http://localhost:8080/employees';

class EmployeeService {
    getEmployees(){
        return axios.get(EMPLOYEE_API_URL);
    }
}

export default new EmployeeService();
