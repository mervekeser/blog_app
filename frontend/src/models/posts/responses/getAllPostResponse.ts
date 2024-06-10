import { GetByIdUserResponse } from "../../users/responses/getByIdUserResponse";

export interface GetAllPostResponse{
    id:number;
    title:string;
    content:string;
    publicationDate:Date;
    user:GetByIdUserResponse;
}