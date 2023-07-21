<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<form>
    <label>Password: <input name="password" id=  type="password" onChange="onChange()" /> </label><br />
    <label>Confirm : <input name="confirm"  type="password" onChange="onChange()" /> </label><br />
    <input type="submit" />
</form>
<script>
    function onChange() {
        const password = document.querySelector('input[name=password]');
        const confirm = document.querySelector('input[name=confirm]');
        if (confirm.value === password.value) {
            confirm.setCustomValidity('');
        } else {
            confirm.setCustomValidity('Passwords do not match');
        }
    }
</script>

</body>
</html>
