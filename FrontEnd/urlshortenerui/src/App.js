import "./App.css";
import CopyToClipboard from "react-copy-to-clipboard";
import {Box, Button, SvgIcon, TextField } from "@mui/material";
import { useState } from "react";
import axios from "axios";
function App() {

  const shortenedUrl="asdf.com/sas";

  const [url, setUrl] =useState("");

  const handleUrlChange = (evt)=>{
    setUrl(evt.target.value);
  }
  const handleSubmitUrl= ()=>{
    console.log(url);
    // axios.post()
  }

  return (
    <>
    <div className="App">
    
    <div >
    <TextField variant="outlined" placeholder="paste the url here:" onChange={
      handleUrlChange
    }></TextField>
      </div>
  
      <div >
        <Button className="textTransformNone" variant="contained"
          onClick={() => {
            handleSubmitUrl();
          }}
        >
          Click here to get your URL shortened
        </Button>
      </div>
      
      <div >
        <span>
         <TextField variant="outlined" value={shortenedUrl} readOnly></TextField>
        <CopyToClipboard text={url}><Button variant="contained" className="textTransforNone">copy url to clipboard</Button></CopyToClipboard>
        </span>
      </div>
      </div>
    </>
  );
}

export default App;
