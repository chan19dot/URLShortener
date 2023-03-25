import { Button } from '@mui/material';
import React from 'react';
import { Link } from 'react-router-dom';

const ErrorPage = () => {
  return (
    <div>
      <h1>Page not found</h1>
      <p>The requested URL has expired.</p>
      <Button variant="contained" color="primary" component={Link} to="/">
        Go to Home Page
      </Button>
    </div>
  );
};

export default ErrorPage;