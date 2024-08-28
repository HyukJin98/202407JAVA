<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div>
        <input type="text" name="id" placeholder="ID">
        <input type="text" name="title" placeholder="Title">
        <input type="text" name="author" placeholder="author">
        <button onclick="createPost()">Create</button>
        <button onclick="readPosts()">Read</button>
        <button onclick="updatePost()">Update</button>
        <button onclick="deletePost()">Delete</button>
    </div>
    <ul class="print-data"></ul>
    <script>
        const apiUrl = 'http://localhost:3000/posts';
        function readPosts() {
            fetch(apiUrl)
            .then(response => response.json())
            .then(data => {
                const printData = document.querySelector('.print-data');
                printData.innerHTML = '';
                data.forEach(post => {
                    printData.innerHTML += `<li>id: ${post.id} <br>title: ${post.title} <br>author: ${post.author}</li>`;
                });
            })
            .catch(error => console.error('Error:', error));
        }
        function createPost() {
            const inputId = document.querySelector('input[name=id]').value;
            const inputTitle = document.querySelector('input[name=title]').value;
            const inputAuthor = document.querySelector('input[name=author]').value;
            
            const postParams = {
                id: inputId,
                title: inputTitle,
                author: inputAuthor
            };

            fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(postParams)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Post created:', data);
                readPosts();
            })
            .catch(error => console.error('Error:', error));
        }
        function updatePost() {
            const inputId = document.querySelector('input[name=id]').value;
            const inputTitle = document.querySelector('input[name=title]').value;
            const inputAuthor = document.querySelector('input[name=author]').value;

            const postParams = {
                id : inputId,
                title : inputTitle,
                author : inputAuthor
            };

            fetch(`${apiUrl}/${inputId}`,{
                method: 'PUT',
                headers: {
                    'Content-Type':'application/json'
                },
                body: JSON.stringify(postParams)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Post updated:',data);
                readPosts();
            }).catch(error => console.error('Error:',error));
        }
        function deletePost() {
            const inputId = document.querySelector('input[name=id]').value;

            fetch(`${apiUrl}/${inputId}`,{
                method:'DELETE'
            })
            .then(response => response.json())
            .then(data =>{
                console.log('Post deleted:', data);
                readPosts();
            }).catch(error => console.error('Error:',error));
        }
    </script>
</body>
</html>