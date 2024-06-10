import { error } from './../../../node_modules/webpack-dev-middleware/node_modules/ajv/lib/vocabularies/applicator/dependencies';
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import postService from "../../services/postService";
import { AddPostRequest } from '../../models/posts/requests/addPostRequest';
import { UpdatePostRequest } from '../../models/posts/requests/updatePostRequest';

export const postList = createAsyncThunk(
    "posts/postList",
    async(thunkAPI)=>{
        try{
            const response = await postService.getAll();
            return response.data;
        }catch(error){
            console.error("Gönderi listeleme hatas:", error);
            throw error;
        }
    }
);

export const addPost = createAsyncThunk(
    "posts/addPost",
    async(newPost:AddPostRequest)=>{
        try{
            const addedPost = await postService.add(newPost);
            return addedPost.data;
        }catch(error){
            console.error("Gönderi ekleme hatas:", error);
            throw error;
        }
    }
);

export const updatePost = createAsyncThunk(
    "posts/updatePost",
    async(newPost: UpdatePostRequest)=>{
        try{
            const updatedPost = await postService.update(newPost);
            return updatedPost.data;
        }catch(error){
            console.error("Gönderi güncelleme hatas:", error);
            throw error;
        }
    }
);

export const deletePost = createAsyncThunk(
    "posts/deletePost",
    async ({id}: {id: number;}, thunkAPI) =>{
        try {
            await postService.delete(id);
            return{
                deletedPostId: id
            };
        } catch (error) {
            console.error("Gönderi silme hatası:", error);
            throw error;
        }
    }
);

const initialState ={
    posts: [] as any,
    loading: "initial",
}
const postSlice = createSlice({
    name: "posts",
    initialState,
    reducers:{},
    extraReducers: (builder) => {
        builder.addCase(postList.pending, state=>{
            state.loading = "loading";
        });
        builder.addCase(postList.fulfilled, (state, action)=>{
            state.posts = action.payload;    
        });
        builder.addCase(postList.rejected, state=>{
            state.loading = "error";
        });


        builder.addCase(addPost.pending, state =>{
            state.loading = "loading";
        });
        builder.addCase(addPost.fulfilled, (state, action)=>{
            state.posts.push(action.payload);
        });
        builder.addCase(addPost.rejected, state=>{
            state.loading = "error";
        });


        builder.addCase(updatePost.pending, state =>{
            state.loading = "loading";
        });
        builder.addCase(updatePost.fulfilled, (state, action) =>{
            state.posts = [];
        });
        builder.addCase(updatePost.rejected, state =>{
            state.loading = "error";
        });


        builder.addCase(deletePost.pending, state =>{
            state.loading = "loading";
        });
        builder.addCase(deletePost.fulfilled, (state, action) =>{
            const deletedBrand = action.payload.deletedPostId;
            state.posts = state.posts.filter((brand: any) => brand.id !== deletePost);
        });
        builder.addCase(deletePost.rejected, state =>{
            state.loading = "error";
        });
    },
});

export const postReducer = postSlice.reducer;
export const {} = postSlice.actions;