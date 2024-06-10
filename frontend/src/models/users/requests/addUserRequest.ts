export interface AddUserRequest{
    name:string;
    surname:string;
    email:string;
    password:string;
    authorities:string[];
}