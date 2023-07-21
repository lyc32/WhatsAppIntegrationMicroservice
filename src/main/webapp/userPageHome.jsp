<div class="container mt-4 mb-4" style="min-height: 800px;">
    <div class="row justify-content-center">
        <div class="card" style="max-width: 600px;">
            <div class="row g-0">
                <form class="row g-3" action="./User/Login" method="post">
                    <div class="card-body">
                        <h3 class="card-title text-center border-bottom  pb-4">User Profile<br>ID:${user.userID}</h3>
                        <p class="card-text pt-0 pb-4">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="col-form-label">User Name: </label>
                            </div>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value='${user.userName}' readonly>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="col-form-label">Phone: </label>
                            </div>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value='${user.phoneNumber}'>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="col-form-label">Email: </label>
                            </div>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value='${user.email}'>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-4">
                                <label class="col-form-label">Date Of Birth:</label>
                            </div>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" value='${user.birthday}'>
                            </div>
                        </div>
                        <br>
                        </p>

                        <p class="card-text pt-2 pb-0  border-top">
                        <div class="row">
                            <div class="col-sm-12 text-end">
                                <label class="col-form-label">Joining Date: ${user.joinDate}</label>
                            </div>
                        </div>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
