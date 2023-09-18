import React from "react";
import axiosInstance from "./axios";

import SideNav, { Toggle, Nav, NavItem, NavIcon, NavText } from '@trendmicro/react-sidenav';
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import Container from "@material-ui/core/Container";
import {Grid} from "@material-ui/core";

import history from './history';
//import styles from 'Login.css';
import '@trendmicro/react-sidenav/dist/react-sidenav.css';
import adminstyle from "./CSS/Admin.module.scss";






class Admin extends React.Component {

    handleInput = event => {
        const {value, name} = event.target;
        this.setState({
            [name]: value
        });
       
    };

    onSubmitAddMovie = event => {
      event.preventDefault();
      let movie= {
          numeM: this.state.numeM,
          gen: this.state.gen,
          descriere : this.state.descriere,
          imagePath : this.state.imagePath
      }

      console.log(movie);
      
     
      axiosInstance.post("/addMovie", movie)
          .then(
              res => {
                  const val = res.data;
                  console.log("Success");
                  console.log(val);
                  localStorage.setItem("movie "+val.numeM , val.id);
                }
          )
          .catch(error => {
              console.log(error)
          })
    }

    onSubmitDeleteMovie = event => {
        event.preventDefault();
        let delmov = {
            numeM: this.state.numeMov,
            gen: this.state.genMov,
        }
        console.log(delmov);
        axiosInstance.post("/deleteMovie", delmov)
            .then(
                res => {
                    const val = res.data;
                    console.log("Success");           
                }
            )
            .catch(error => {
                console.log(error)
            })
    }

    onSubmitDeleteClient = event => {
        event.preventDefault();
           
            console.log(this.state.email);
            axiosInstance.post("/deleteClient", this.state.email)
                .then(
                    res => {
                        const val = res.data;
                        console.log("Success");           
                }
                )
                .catch(error => {
                    console.log(error)
                })
    }

    handle = (selected) => {
        const to = '/' + selected;
        if (location.pathname !== to) {
            if(to == '/log-in')
            {
                axiosInstance.post("/logout", localStorage.getItem('USER_ID'))
                .then(
                    res => {
                        
                    }
                )
                .catch(error => {
                    console.log(error)
                })
                localStorage.removeItem('USER_ID');
                console.log(to);
                history.push(to);
                window.location.reload();
            }else
            {
                if(to=="/home" && localStorage.getItem("user")=="admin@gmail.com")
                {
                    console.log(to);
                    history.push("/admin");
                    window.location.reload();
                }else
                {
                console.log(to);
                history.push(to);
                window.location.reload();
                }
               
            }
           
        }
    }


    onSubmitAddActor = event => {
        event.preventDefault();
        let actor= {
            nume: this.state.nume,
            varsta: this.state.varsta,
            istoric : this.state.istoric,
            imagePatha : this.state.ActorImagePath
        }
  
        console.log(actor);
        
       
        axiosInstance.post("/addActor", actor)
            .then(
                res => {
                    const val = res.data;
                    console.log("Success");
                    console.log(val);
                  }
            )
            .catch(error => {
                console.log(error)
            })
    }


    onSubmitAddActorToMovie = event => {
        event.preventDefault();

        let data = {
            actor: this.state.actorMovie,
            movie: this.state.movieActor
        }
       
       
        axiosInstance.post("/addActorToMovie", data)
            .then(
                res => {
                    const val = res.data;
                    console.log("Success");           
            }
            )
            .catch(error => {
                console.log(error)
            })
    }


    onSubmitDeleteActorList = event => {
        event.preventDefault();

        let data = {
            actor: this.state.actorMovie1,
            movie: this.state.movieActor1
        }
       
       
        axiosInstance.post("/deleteActorList", data)
            .then(
                res => {
                    const val = res.data;
                    console.log("Success");           
            }
            )
            .catch(error => {
                console.log(error)
            })
    }



    generateXML () {
          
        axiosInstance.post("/generateXML")
        .then(
            res => {
                const val = res.data;
               
            }
        )
        .catch(error => {
            console.log(error)
        })
       // window.location.reload();
      
    }

    render() {
        return (
                <div className={adminstyle.adminbody}>
                    
                       
                        <SideNav
                             onSelect={this.handle}

                            >
                            <SideNav.Toggle />
                            <SideNav.Nav defaultSelected="admin">
                                <NavItem eventKey="admin">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Home
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="mylist">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        My Movie List
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="search">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Search Movie
                                    </NavText>
                                </NavItem>
                                <NavItem eventKey="log-in">
                                    <NavIcon>
                                        <i className="fa fa-fw fa-home" style={{ fontSize: '1.75em' }} />
                                    </NavIcon>
                                    <NavText>
                                        Log Out
                                    </NavText>
                                </NavItem>
                               
                            </SideNav.Nav>
                        </SideNav>

            




                        <div className="page-wrap">
                            <div className="jumbotron">
                            <div style={{marginTop: '130px'}} className="container">
                             
                                <a href="#" className="h5 close-menu"><i style={{color: '#fff', position: 'relative', bottom: '120px', cursor: 'pointer'}} className="fa fa-times fa-2x fa-fw" /></a>
                                <h1>Filmento</h1>
                                <div className="spacer" />
                                <hr />
                                <hr />
                                <h2 className="text-center">The best place for movies</h2>
                            </div>
                            </div>
                            <div className="section" id="about">
                            <h1>About</h1>
                            <hr />
                            </div>
                            <div className="container">
                            <div className="row">
                                <div className="col-md-8">
                                <div className="well">
                                    <h3>Filmento</h3>
                                    <p>A place for cinematografy and cinephiles, where you can share your opinions about movies , rate them , get all kind of information about them , and recieve great recomandations and news</p>
                                </div>
                                </div>
                            </div>
                            {/*/.row*/}
                            </div>
                           
                       
                            
                        </div>





                    <Container maxWidth="sm">
                        <div>
                            <Grid>
                                <form onSubmit={this.onSubmitAddMovie}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="moviename"
                                        label="Name"
                                        name="numeM"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        name="gen"
                                        label="Category"
                                        id="moviegen"
                                        onChange={this.handleInput}
                                        
                                    /> 
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="moviedescriere"
                                        label="Description"
                                        name="descriere"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />

                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        name="imagePath"
                                        label="Image Path"
                                        id="movieimagepath"
                                        onChange={this.handleInput}
                                        
                                    />
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Add Movie
                                    </Button>
                                </form>


                                <form onSubmit={this.onSubmitDeleteMovie}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="deletemovie"
                                        label="Insert the name of the movie you want to delete"
                                        name="numeMov"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />

                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="deletemoviegen"
                                        label="Insert the category of the movie you want to delete"
                                        name="genMov"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                   
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Delete Movie
                                    </Button>
                                </form>

                                <form onSubmit={this.onSubmitDeleteClient}>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="deleteclient"
                                        label="Insert the name of the client to delete it"
                                        name="email"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                   
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Delete Client
                                    </Button>
                                </form>

                                <form onSubmit={this.onSubmitAddActor} >
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="addactor"
                                        label="Insert the name of the actor"
                                        name="nume"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />

                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="vactor"
                                        label="Insert the age of the actor"
                                        name="varsta"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />

                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="iactor"
                                        label="Description"
                                        name="istoric"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />

                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="imgactor"
                                        label="Insert image path"
                                        name="ActorImagePath"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />  
                                   
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Add Actor
                                    </Button>
                                </form>

                                <form onSubmit={this.onSubmitAddActorToMovie }>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="actorToMovie"
                                        label="Insert the name of the movie"
                                        name="movieActor"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                     <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="actorMovie"
                                        label="Insert the actor associated with the movie"
                                        name="actorMovie"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                   
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Add actor to movie
                                    </Button>
                                </form>

                                <form onSubmit={this.onSubmitDeleteActorList }>
                                    <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="movieActor1"
                                        label="Insert the name of the movie"
                                        name="movieActor1"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                     <TextField
                                        variant="outlined"
                                        margin="normal"
                                        required
                                        fullWidth
                                        id="actorToMovie1"
                                        label="Insert the actor associated with the movie"
                                        name="actorMovie1"
                                        
                                        onChange={this.handleInput}
                                        autoFocus
                                    />
                                   
                                    <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                    >
                                        Delete Actor From Movie
                                    </Button>
                                </form>
                                <br />
                                <br />
                                <Button
                                        type="submit"
                                        fullWidth
                                        variant="contained"
                                        color="primary"
                                        onClick={this.generateXML}
                                    >
                                        Generate XML Report
                                </Button>


                            </Grid>
                        </div>
                    </Container>

                </div>

        )
    }

}
 
export default Admin;