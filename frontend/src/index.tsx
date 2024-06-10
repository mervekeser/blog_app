import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { injectStore } from './core/utils/interceptors/axiosInterceptors';
import { store } from './store/store';
import { BrowserRouter } from 'react-router-dom';
import { Provider } from 'react-redux';

import { ThemeProvider } from "@material-tailwind/react";

injectStore(store)


const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  <ThemeProvider>
  <Provider store={store}>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </Provider>  
  </ThemeProvider>
);


