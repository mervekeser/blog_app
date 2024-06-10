import { EnhancedStore } from "@reduxjs/toolkit";
import axios from "axios";
import tokenService from "../../../services/tokenService";
import { decreaseRequestCount, increaseRequestCount } from "../../../store/slices/loadingSlice";

let store:EnhancedStore

export const injectStore = (_store: EnhancedStore)=>{
    store = _store
}

const axiosInstance = axios.create({
    baseURL: "http://localhost:8080/api/v1"
});

axiosInstance.interceptors.request.use(config => {
    let token = tokenService.getToken();
    if(token) config.headers.Authorization = `Bearer ${token}`;

    store.dispatch(increaseRequestCount());
    return config;
})

axiosInstance.interceptors.response.use(
    response => {
      store.dispatch(decreaseRequestCount());
      return response
    },
    error => {
      store.dispatch(decreaseRequestCount());
  
    },
  )
  
  
  
  export default axiosInstance;