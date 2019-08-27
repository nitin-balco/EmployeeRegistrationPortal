import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions, URLSearchParams} from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class EmployeeRegistrationService {
    response : string;
    constructor(private _http: Http) {
    }

    getAllRegisteredEmployees() {
        return this._http.get("http://localhost:8080/getAllRegisteredEmployees")
        .map((response: Response) => response.json());
    }

    registerEmployee(employeeEntity: any) {
        let response = '';
        const headers = new Headers();
        headers.append('Content-Type', 'application/json');
        headers.append('Access-Control-Allow-Origin', '*');
        const body = employeeEntity;
        return this._http.post("http://localhost:8080/registerEmployee", JSON.stringify(body), {headers:headers})
        .map((response: Response) => response.json());
    }

}