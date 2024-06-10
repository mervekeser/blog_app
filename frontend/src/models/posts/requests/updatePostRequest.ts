export interface UpdatePostRequest{
    id?:number;
    title?:string;
    content?:string;
    publicationDate?:Date;
    userId?:number;
}