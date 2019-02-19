const API_BASE_URL = 'http://localhost:8080/api';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json'
    })

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response =>
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

export function getAllBlogs() {
    return request({
        url: API_BASE_URL + "/blogs",
        method: 'GET'
    });
}
