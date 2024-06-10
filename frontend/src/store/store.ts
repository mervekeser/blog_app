import { configureStore } from "@reduxjs/toolkit";
import { loadingReducer } from "./slices/loadingSlice";
import { userReducer } from "./slices/userSlice";
import { authReducer } from "./slices/authSlice";
import { postReducer } from "./slices/postSlice";

export const store = configureStore({
    reducer:{
        loading: loadingReducer,
        user: userReducer,
        auth: authReducer,
        post: postReducer
    }
})
export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch