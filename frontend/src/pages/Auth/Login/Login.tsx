import React, { useState } from "react";
import FormikInput from "../../../components/FormikInput/FormikInput";
import { Form, Formik } from "formik";
import { object, string } from "yup";
import { useLocation, useNavigate } from "react-router-dom";
import Link from "../../../components/UserLink/Link";
import { useDispatch, useSelector } from "react-redux";
import { AppDispatch } from "../../../store/store";
import { setIsLoggedIn, userInfo } from "../../../store/slices/userSlice";
import { jwtDecode } from "jwt-decode";
import { MyJwtPayload } from "../../../models/jwt/MyJwtPayload";
import { AuthenticateRequest } from "../../../models/auth/requests/authenticateRequest";
import authService from "../../../services/authService";

type Props = {};

const Login = (props: Props) => {
  const [credentials, setCredentials] = useState({});
  const rentalState = useSelector((state: any) => state.rental);

  const location = useLocation();
  const navigate = useNavigate();
  const dispatch = useDispatch<AppDispatch>();

  const initialValues = {
    email: "",
    password: "",
  };

  const validationSchema = object({
    email: string().email("Geçersiz email").required("Mail boş geçilemez."),
    password: string()
      .required("Şifre alanı zorunludur.")
      .min(5, "Şifre minimum 5 karakter uzunluğunda olmalıdır.")
      .max(30),
  });

  const handleLogin = (values: AuthenticateRequest) => {
    authService.authenticate(values).then(
      (response) => {
        console.log(response);
        if (!response) {
          alert("Kullanıcı adı veya Şifre Yanlış. Lütfen tekrar deneyiniz.");
          //localStorage.removeItem('jsonwebtoken'); // Anahtarı sil
          //navigate('/login'); // useNavigate ile giriş sayfasına yönlendir
        } else {
          const token = response.data.token;
          localStorage.setItem("jsonwebtoken", token);
          dispatch(setIsLoggedIn(true));

          const decoded = jwtDecode(token!) as MyJwtPayload;
          if (decoded.role?.includes("ADMIN")) {
            localStorage.setItem("isLoggedIn", "true");
            navigate("/admin");
          } else {
            navigate(location.state?.from || "/");
          }
        }
      },
      (error) => {
        console.log(error);
      }
    );
  };
  return (
    <div
      className="container w-full mx-auto flex justify-center items-center md:pt-2 md:pb-20 py-10 h-screen"
      // style={{ height: "calc(100vh - 7rem)" }}
    >
      <div className="md:w-[70%] md:h-[80%] w-[80%] h-[80%] ">
        <div className="grid">
          <div
            className=" grid md:rounded-s-3xl w-full md:px-10 px-2"
          >
            <div
              className="flex flex-col justify-center"
            >
              <div
                className="flex justify-center "
              >
                <img
                  className="md:w-40 md:h-40 w-20 h-20 rounded-xl"
                  src="https://img.freepik.com/free-vector/blogging-fun-content-creation-online-streaming-video-blog-young-girl-making-selfie-social-network-sharing-feedback-self-promotion-strategy-vector-isolated-concept-metaphor-illustration_335657-855.jpg?size=338&ext=jpg&ga=GA1.1.1412446893.1717891200&semt=sph"
                  alt="BlogLogo"
                />
              </div>

              <div className="flex justify-center mt-3 text-3xl font-bold text-purple-500">
                <p>GİRİŞ YAP</p>
              </div>

              <div className="flex justify-center mt-5">
                <Formik
                  initialValues={initialValues}
                  onSubmit={(values) => {
                    handleLogin(values);
                    setCredentials(values);
                  }}
                  validationSchema={validationSchema}
                >
                  <Form
                    className="p-0 shadow-none min-w-[100px] "
                  >
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

                    <div className="flex items-center justify-between">
                      <div className="text-sm ml-auto pb-3 mb-2">
                        <a
                          href="#"
                          className="text-purple-500 font-bold"
                        >
                          Şifremi unuttum
                        </a>
                      </div>
                    </div>

                    <div>
                      <button
                        type="submit"
                        className="w-full flex justify-center bg-purple-600 hover:bg-purple-300 text-purple-200 hover:text-purple-600 p-3  rounded-lg tracking-wide font-semibold  cursor-pointer transition ease-in duration-500 "
                      >
                        Giriş Yap
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

              <div className="mb-7 flex justify-center">
                <p className="text-purple-500 flex">
                  Hesabın yok mu?
                  <Link
                    className="text-purple-500 hover:text-purple-300 ms-1 font-bold"
                    to="/signup"
                  >
                    Üye ol
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

export default Login;
