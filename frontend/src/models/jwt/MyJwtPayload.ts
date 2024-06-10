import { JwtPayload } from "jwt-decode";

export interface MyJwtPayload extends JwtPayload{
    firstname?: string;
    lastname?: string;
    email?: string;
    id?: number;
    role?: string[];
}