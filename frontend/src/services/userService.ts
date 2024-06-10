import axiosInstance from "../core/utils/interceptors/axiosInterceptors";
import { AddUserRequest } from "../models/users/requests/addUserRequest";
import { UpdateUserRequest } from "../models/users/requests/updateUserRequest";
import { AddUserResponse } from "../models/users/responses/addUserResponse";
import { GetAllUserResponse } from "../models/users/responses/getAllUserresponse";
import { GetByIdUserResponse } from "../models/users/responses/getByIdUserResponse";
import { UpdateUserResponse } from "../models/users/responses/updateUserResponse";
import { BaseService } from "./baseService";

class UserService extends BaseService<
    GetAllUserResponse,
    GetByIdUserResponse,
    AddUserRequest,
    AddUserResponse,
    UpdateUserRequest,
    UpdateUserResponse
>{
    constructor(){
        super();
        this.apiUrl = "users";
    }

    getUserInfo(email?:string){
        return axiosInstance.get(this.apiUrl + "/getUserInfo", {
          params: {
            email: email
          }
        });
    }
    
}
export default new UserService();