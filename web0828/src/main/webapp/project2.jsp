
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        const apiUrl = 'http://localhost:3000/posts';
        function readPosts() {
        	$.ajax({
                url: apiUrl,
                method: 'GET',
                success: function(data) {
                    const printData = $('.print-data');
                    printData.empty();
                    console.log(printData);
                    data.forEach(post => {
                        printData.append(`<li>id: ${post.id} <br>title: ${post.title} <br>author: ${post.author}</li>`);
                    });
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
        function createPost() {
        	const inputId = $('input[name=id]').val();
            const inputTitle = $('input[name=title]').val();
            const inputAuthor = $('input[name=author]').val();

            const postParams = {
                id: inputId,
                title: inputTitle,
                author: inputAuthor
            };

            $.ajax({
                url: apiUrl,
                method: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(postParams),
                success: function(data) {
                    console.log('Post created:', data);
                    readPosts();
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
        function updatePost() {
        	const inputId = $('input[name=id]').val();
            const inputTitle = $('input[name=title]').val();
            const inputAuthor = $('input[name=author]').val();

            const postParams = {
                id: inputId,
                title: inputTitle,
                author: inputAuthor
            };

            $.ajax({
                url: `${apiUrl}/${inputId}`,
                method: 'PUT',
                contentType: 'application/json',
                data: JSON.stringify(postParams),
                success: function(data) {
                    console.log('Post updated:', data);
                    readPosts();
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
        function deletePost() {
        	const inputId = $('input[name=id]').val();

            $.ajax({
                url: `${apiUrl}/${inputId}`,
                method: 'DELETE',
                success: function(data) {
                    console.log('Post deleted:', data);
                    readPosts();
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    </script>
</body>
</html>
