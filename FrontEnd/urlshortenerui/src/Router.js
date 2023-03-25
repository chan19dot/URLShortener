import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import App from './App';
import ErrorPage from './ErrorPage';

const RouterComponent = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/linkHasExpired" element={<ErrorPage />} />
      </Routes>
    </Router>
  );
};

export default RouterComponent;
