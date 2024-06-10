import React, { useState } from "react";
import FormikInput from "../../../components/FormikInput/FormikInput";
import { Form, Formik } from "formik";
import { object, string } from "yup";
import { useNavigate } from "react-router-dom";
import Link from "../../../components/UserLink/Link";
import { RegisterRequest } from "../../../models/auth/requests/registerRequest";
import { AppDispatch } from "../../../store/store";
import { useDispatch } from "react-redux";
import authService from "../../../services/authService";

type Props = {};

const Signup = (props: Props) => {
  // const [credentials, setCredentials] = useState({});

  const navigate = useNavigate();
  const dispatch = useDispatch<AppDispatch>();

  const initialValues = {
    name: "",
    surname: "",
    email: "",
    password: "",
    authorities: ["USER"],
  };

  const validationSchema = object({
    name: string()
      .required("İsim alanı zorunludur.")
      .min(2, "İsim minimum 2 karakter uzunluğunda olmalıdır.")
      .max(50),
    surname: string()
      .required("Soyad alanı zorunludur.")
      .min(2, "Soyad minimum 2 karakter uzunluğunda olmalıdır.")
      .max(50),
    email: string().email("Geçersiz email").required("Mail boş geçilemez."),
    password: string()
      .required("Şifre alanı zorunludur.")
      .min(5, "Şifre minimum 5 karakter uzunluğunda olmalıdır.")
      .max(30),
  });

  const handleLogin = (values: RegisterRequest) => {
    authService.register(values).then(
      (response) => {
        console.log(response);
        navigate("/login");
      },
      (error) => {
        console.log(error);
      }
    );
  };
  return (
    <div
      className="container w-full mx-auto flex justify-center items-center md:pt-2 md:pb-20 "
      // style={{ height: "calc(100vh - 7rem)" }}
    >
      <div className="md:w-[70%] md:h-[80%] w-[80%] h-[80%]">
        <div className="grid h-full ">
          <div
            className="grid md:rounded-s-3xl w-full md:px-10 px-2"
          >
            <div
              className="flex flex-col justify-center"
            >
              <div
                className="flex justify-center"
              >
                <img
                  className="md:w-40 md:h-40 w-20 h-20 rounded-xl"
                  src="https://img.freepik.com/free-vector/blogging-fun-content-creation-online-streaming-video-blog-young-girl-making-selfie-social-network-sharing-feedback-self-promotion-strategy-vector-isolated-concept-metaphor-illustration_335657-855.jpg?size=338&ext=jpg&ga=GA1.1.1412446893.1717891200&semt=sph"
                  alt="BlogLogo"
                />
              </div>

              <div className="flex justify-center  mt-5 text-3xl font-bold text-purple-500">
                <p>ÜYE OL</p>
              </div>

              <div className="flex justify-center mt-5">
                <Formik
                  initialValues={initialValues}
                  onSubmit={(values) => {
                    handleLogin(values);
                    // setCredentials(values);
                  }}
                  validationSchema={validationSchema}
                >
                  <Form
                    className="p-0 shadow-none min-w-[100px] "
                    data-aos="fade-right"
                    data-aos-duration="1500"
                    data-aos-easing="ease-in-sine"
                    data-aos-delay="800"
                  >
                    <div className="grid grid-cols-1 md:grid-cols-2 gap-2">
                      <div>
                        <FormikInput
                          name="name"
                          label="Ad"
                          type="text"
                          placeholder="Adınızı giriniz..."
                        />
                      </div>
                      <div>
                        <FormikInput
                          name="surname"
                          label="Soyad"
                          type="text"
                          placeholder="Soyadınızı giriniz..."
                        />
                      </div>
                    </div>
                    <FormikInput
                      name="email"
                      label="Email"
                      type="email"
                      placeholder="Mailinizi giriniz..."
                    />
                    <FormikInput
                      name="password"
                      label="Şifre"
                      type="password"
                      placeholder="Şifrenizi giriniz..."
                    />

                    <div className="mt-8">
                      <button
                        type="submit"
                        className="w-full flex justify-center bg-purple-500 hover:bg-purple-300 text-purple-200 hover:text-purple-500 p-3  rounded-lg tracking-wide font-semibold  cursor-pointer transition ease-in duration-500 "
                      >
                        Üye Ol
                      </button>
                    </div>
                  </Form>
                </Formik>
              </div>

              <div className="flex items-center justify-center space-x-2 my-5">
                <span
                  className="h-px w-16 bg-purple-500"
                  data-aos="fade-right"
                  data-aos-duration="1500"
                  data-aos-easing="ease-in-sine"
                  data-aos-delay="800"
                ></span>
                <span
                  className="text-purple-500 font-normal"
                  data-aos="fade-down"
                  data-aos-duration="1500"
                  data-aos-easing="ease-in-sine"
                  data-aos-delay="800"
                >
                  or
                </span>
                <span
                  className="h-px w-16 bg-purple-500"
                  data-aos="fade-left"
                  data-aos-duration="1500"
                  data-aos-easing="ease-in-sine"
                  data-aos-delay="800"
                ></span>
              </div>

              <div className=" flex justify-center">
                <p className="text-purple-500 flex">
                  Hesabın var mı?
                  <Link
                    className="text-purple-500 hover:text-purple-600 ms-1 font-bold"
                    to="/login"
                  >
                    Giriş yap
                  </Link>
                </p>
              </div>
            </div>
          </div>

        </div>
      </div>
    </div>
  );
};

export default Signup;
