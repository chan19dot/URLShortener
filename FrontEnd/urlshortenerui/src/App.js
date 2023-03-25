import "./App.css";
import CopyToClipboard from "react-copy-to-clipboard";
import {Box, Button, SvgIcon, TextField } from "@mui/material";
function App() {

  const url="asdf.com/sas";

  return (
    <>
    <div className="App">
    
    <div >
    <TextField variant="outlined" placeholder="paste the url here:" ></TextField>
      </div>
  
      <div >
        <Button className="textTransformNone" variant="contained"
          onClick={() => {
            console.log("button clicked");
          }}
        >
          Click here to get your URL shortened
        </Button>
      </div>
      
      <div >
        <span>
         <TextField variant="outlined" value={url} readOnly></TextField>
        <CopyToClipboard text={url}><Button variant="contained" className="textTransforNone">copy url to clipboard</Button></CopyToClipboard>
        </span>
      </div>
      </div>
    </>
  );
}

export default App;
