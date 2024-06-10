import { AddPostRequest } from "../models/posts/requests/addPostRequest";
import { UpdatePostRequest } from "../models/posts/requests/updatePostRequest";
import { AddPostResponse } from "../models/posts/responses/addPostResponse";
import { GetAllPostResponse } from "../models/posts/responses/getAllPostResponse";
import { GetByIdPostResponse } from "../models/posts/responses/getByIdPostResponse";
import { UpdatePostResponse } from "../models/posts/responses/updatePostResponse";
import { BaseService } from "./baseService";

class PostService extends BaseService<
        GetAllPostResponse,
        GetByIdPostResponse,
        AddPostRequest,
        AddPostResponse,
        UpdatePostRequest,
        UpdatePostResponse>{
            constructor(){
                super();
                this.apiUrl = "posts";
            }
   
        }
        export default new PostService();