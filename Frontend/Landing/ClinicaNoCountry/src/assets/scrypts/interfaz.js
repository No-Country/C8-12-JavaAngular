var registros = [];

function agregarDatos(nombre, apellido, documento,mail,pass) {

    var nuevoRegistro = {
        nombre: nombre,
        apellido: apellido,
        documento: documento,
        mail: mail,
        pass: pass
    };

    console.log(nuevoRegistro);
    registros.push(nuevoRegistro);

    /* openDb(); */


}

function obtenerDatos() {
    return registros;
}

//Opening a Database
function openDb(){
    // Open the database
    //parameters - database name and version number. - integer
    var db
    var request = indexedDB.open("Database", 4);
    db = this.result

    //Generating handlers
    //Error handlers
    request.onerror = function(event) {
      console.log("Error: ")
    };

    //OnSuccess Handler
    request.onsuccess = function(event) {
         console.log("Success: ")
         db = event.target.result
     };

      //OnUpgradeNeeded Handler
    request.onupgradeneeded = function(event) {
      console.log("On Upgrade Needed")

        db = event.target.result;

        // Create an objectStore for this database
        //Provide the ObjectStore name and provide the keyPath which acts as a primary key
        var objectStore = db.createObjectStore("Registros", {keyPath: 'id', autoIncrement: true });


        for (i = 0; i < registros.length; i++) {
            objectStore.put(registros[i]);
        }

    };
  }


  function getObjectStore(store_name, mode) {
    var tx = db.transaction(store_name, mode);
    return tx.objectStore(store_name);
    }

//Adding to the Database
function addPerson(store_name, obj) {
    var store = getObjectStore(store_name, 'readwrite');
    var req;
    try {
      req = store.add(obj);
    } catch (e) {
      throw e;
    }
    req.onsuccess = function (evt) {
      alert("Insertion in DB successful");
    };
    req.onerror = function() {
      alert("Insertion in DB Failed ", this.error);
    };
  }

  function clearObjectStore(store_name) {
    //Get the ObjectStore
    var store = getObjectStore(store_name, 'readwrite');
    //Clear the ObjectStore
    var req = store.clear();
    //Success Handler
    req.onsuccess = function(event) {
      alert("clear successful")
    };
    //Error Handler
    req.onerror = function (event) {
      alert("clear failed")
    };
  }

  //Read All data in ObjectStore
function readAll(store_name){
    //Create an array
    var peopleArray = [];
    //Get the ObjectStore
    objectStore = getObjectStore(store_name, 'readwrite')

    //Open the Cursor on the ObjectStore
    objectStore.openCursor().onsuccess = function(event) {
                var cursor = event.target.result;
                //If there is a next item, add it to the array
                if (cursor) {
              peopleArray.push(cursor.value);
              alert(cursor.value)
              cursor.continue();
                }
                //else get an alert informing you that it is done
                else {
              alert("All done:");
                }
    };
}
