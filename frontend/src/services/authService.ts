import { RegisterRequest } from "../models/auth/requests/registerRequest";
import axiosInstance from "../core/utils/interceptors/axiosInterceptors";
import { AuthenticateRequest } from "../models/auth/requests/authenticateRequest";

class AuthService{
    register(value:RegisterRequest){
        return axiosInstance.post("auth/register", value);
    }

    authenticate(value:AuthenticateRequest){
        return axiosInstance.post("auth/authenticate", value);
    }
}
export default new AuthService();