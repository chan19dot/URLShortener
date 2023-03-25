import "./App.css";
import CopyToClipboard from "react-copy-to-clipboard";
import {  Button, TextField, Typography } from "@mui/material";
import { useState } from "react";
import axios from "axios";
function App() {

  const apiEndpoint= process.env.REACT_APP_API_ENDPOINT;
  const [url, setUrl] = useState("");
  const [shortUrl, setShortUrl]= useState("");

  const handleUrlChange = (evt) => {
    setUrl(evt.target.value);
  };
  const handleSubmitUrl = async() => {
    try{
      const resp = await axios.post(apiEndpoint+"getShortenedUrl", {
        url:url
      })
      if(resp.data){
        if(resp.data.isDuplicate){
          alert("This URL is already present and the same short URL is provided here:");
        }
        else{
          setShortUrl(resp.data.shortenedUrl);
        }
      }
      
    }
    catch(error){
      console.error(error);
    }
    
    
  };

  return (
    <>
      <div className="App">
        <div>
          <TextField
            variant="outlined"
            placeholder="paste the url here:"
            onChange={handleUrlChange}
          ></TextField>
        </div>

        <div>
          <Button
            className="textTransformNone"
            variant="contained"
            onClick={() => {
              handleSubmitUrl();
            }}
          >
            Click here to get your URL shortened
          </Button>
        </div>

        <div>
          <span>
            <Typography> {shortUrl}</Typography>
            
            <CopyToClipboard text={shortUrl}>
              <Button
                style={{ marginTop: "1.5vw" }}
                variant="contained"
                className="textTransforNone"
              >
                copy url to clipboard
              </Button>
            </CopyToClipboard>
          </span>
        </div>
      </div>
    </>
  );
}

export default App;
