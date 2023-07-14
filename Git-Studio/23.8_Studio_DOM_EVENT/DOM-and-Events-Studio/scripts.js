window.addEventListener('load', function(){
    let flightStatus = document.getElementById('flightStatus');
    let height = document.getElementById('spaceShuttleHeight');
    let shuttleBackground = document.getElementById('shuttleBackground');
    let takeOff = document.getElementById('takeoff');
    let landing = document.getElementById('landing');
    let abort = document.getElementById('missionAbort');
    let rocket = document.getElementById('rocket');
    let rocketPosition = `
        position: absolute;
        left: 220px;
        bottom: 0;`
    rocket.style = rocketPosition;
    let up = document.getElementById('up');
    let down = document.getElementById('down');
    let right = document.getElementById('right');
    let left = document.getElementById('left');
    let landingHeight = 0; 
    let landingXAxis = parseInt(rocket.style.left)
console.log(landingXAxis)
    //take-off button is clicked
    takeOff.addEventListener('click', function(){
        //confirm window for take off (use descr)
        if(flightStatus.innerHTML === "The shuttle has landed." || flightStatus.innerHTML === "Space shuttle ready for takeoff" || flightStatus.innerHTML === "Mission aborted."){
            if(confirm("Confirm that the shuttle is ready for takeoff.")){
                flightStatus.innerHTML = "Shuttle in flight.";
                shuttleBackground.style.backgroundColor = '#44b4f5';
                height.innerText = 10000;
                landingHeight = landingHeight + 10;
                rocket.style.bottom = landingHeight+'px';
            }
        } else {
            return false;
        }        
    })

    //land button is clicked
    landing.addEventListener('click', function(){
        if(flightStatus.innerHTML === "The shuttle has landed." || flightStatus.innerHTML === "Space shuttle ready for takeoff" || flightStatus.innerHTML === "Mission aborted."){
            return false;
        } else {
            alert("The shuttle is landing. Landing gear engaged.");
            flightStatus.innerHTML = "The shuttle has landed."
            shuttleBackground.style.backgroundColor = '';
            height.innerText = 0;
            rocket.style = rocketPosition;
            landingHeight = 0;
        }
        
    })

    //Abort Mission button clicked
    abort.addEventListener('click', function(){
        if(flightStatus.innerHTML === "The shuttle has landed." || flightStatus.innerHTML === "Space shuttle ready for takeoff" || flightStatus.innerHTML === "Mission aborted."){
            return false;
        } else {
            if(confirm("Confirm that you want to abort the mission.")){
                    flightStatus.innerHTML = "Mission aborted.";
                    shuttleBackground.style.backgroundColor = "";
                    height.innerHTML = 0;
                    rocket.style = rocketPosition;
                    landingHeight = 0;
            } else {
                return false;
            }
        }
            
    })
        

    //up down right left buttons clicked
        //rocket image moves 10  pixels in direction of button
        //if up or down clicked, shuttle height increase or decrease by 10 pixels
        
        up.addEventListener('click', function(){
            if(height.innerHTML >= 250000){
                rocket.style.bottom = rocket.style.bottom;    
            } else {
                landingHeight = landingHeight + 10;
                rocket.style.bottom = landingHeight+'px';
            }
            height.innerHTML = parseInt(height.innerHTML) + 10000;
        })
        down.addEventListener('click', function(){
             if(height.innerHTML === "0"){
                return false;
             } else {
                if(height.innerHTML > 250000){
                    rocket.style.bottom = rocket.style.bottom;   
                } else {
                    landingHeight = landingHeight - 10;
                    rocket.style.bottom = landingHeight+'px'; 
                }
                height.innerHTML -= 10000;
             }
         })
         right.addEventListener('click', function(){
            if(landingXAxis < 440) {
                landingXAxis = landingXAxis + 10; 
                rocket.style.left = landingXAxis+'px';
                console.log(rocket.style.left)
            } else {
             return false;
            }
        })
         left.addEventListener('click', function(){
               if(landingXAxis > 0) {
                   landingXAxis = landingXAxis - 10; 
                   rocket.style.left = landingXAxis+'px';
               } else {
                return false;
               }
               
        })
//BONUS
    //if absolute position matches edges of screen return current absolute position
    //else change position by 10 pixels
    //when landing or abort: move rocket image back to center ground by looping 10 pixels at a time
        //x-axis to center first 
        //y-axis to ground seconds

})//end of window.addeventlistener