// this object contains the functions which handle the data and its reading/writing
// feel free to extend and change to fit your needs

// (watch out: when you would like to use a property/function of an object from the
// object itself then you must use the 'this' keyword before. For example: 'this._data' below)
export let dataHandler = {
    _data: {}, // it contains the boards and their cards and statuses. It is not called from outside.
    _api_get: function (url, callback) {
        // it is not called from outside
        // loads data from API, parses it and calls the callback with it

        fetch(url, {
            method: 'GET',
            credentials: 'same-origin'
        })
            .then(response => response.json()
    )  // parse the response as JSON
    .
        then(json_response => callback(json_response)
    )
        ;  // Call the `callback` with the returned object
    },
    _api_post: function (url, data, callback) {
        // it is not called from outside
        // sends the data to the API, and calls callback function
        let XHR = new XMLHttpRequest();
        let jsonData = JSON.stringify(data);
        if (callback != null) {
            XHR.addEventListener("load", function (event) {
                callback();
            });
        }
        XHR.addEventListener("error", function (event) {
            alert('Sorry, could not send this.');
        });
        XHR.open("POST", url);
        XHR.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        XHR.send(jsonData);
    },
    sendData: function (data, url) {
        dataHandler._api_post(url, data);
    },
};
