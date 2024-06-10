import React, { useEffect, useState } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { AppDispatch } from '../../store/store';
import { userList } from '../../store/slices/userSlice';
import { date, number, object, string } from 'yup';
import { addPost } from '../../store/slices/postSlice';
import { Field, Form, Formik } from 'formik';
import FormikInput from '../FormikInput/FormikInput';
import { GetAllUserResponse } from '../../models/users/responses/getAllUserresponse';

const AddPost = () => {
    const dispatch = useDispatch<AppDispatch>();
    const[selectedValue, setSelectedValue] = useState({});
    const userState = useSelector((state:any)=> state.user);

    useEffect(()=>{
        dispatch(userList());
    }, [dispatch]);

    const initialValues = {
        title: "",
        content: "",
        publicationDate: 0,
        userId: 0
    };

    const validationSchema = object({
        title: string().required("Başlık alanı zorunludur").min(1),
        content: string().required("İçerik alanı zorunludur").min(5),
        publicationDate:date(),
        userId: number().required("Gönderi oluşturmak için giriş yapın"),
    });

    const handleAddPost = (values:any)=>{
        dispatch(addPost(values));
    }

  return (
    <div className='flex justify-center mt-10'>
        
      <Formik
        initialValues={initialValues}
        onSubmit={(values, {resetForm})=>{
            handleAddPost(values);
            setSelectedValue(values);
            resetForm();
        }}
        validationSchema={validationSchema}
        enableReinitialize={true}
      >
        <Form className='p-0 shadow-none min-w-[300px] '>
           <div className="grid grid-cols-1 sm:grid-cols-1 gap-2">
            <FormikInput
                name='title'
                label='title'
                type='text'
            />
           </div>
           <div className="grid grid-cols-1 sm:grid-cols-1 gap-2">
            <label>Content</label>
            <Field
                name='content'
                as='textarea'
                rows="10" cols="60"
            />
            </div> 
            <div className="grid grid-cols-1 sm:grid-cols-1 gap-2">
            User Bilgisi
           {userState.users.map((user:GetAllUserResponse)=>(
                <label key={user.id} >User Bilgisi{user.name} </label>
            ))} 
            </div>
            <div className='mt-8'>
            <button type='submit' className='w-full flex justify-center bg-purple-600 hover:bg-purple-200 text-delta-green-400 hover:text-purple-600 p-3  rounded-lg tracking-wide font-semibold  cursor-pointer transition ease-in duration-500'>Gönderi Oluştur</button>
            </div>
        </Form>
      </Formik>
    </div>
  )
}

export default AddPost
