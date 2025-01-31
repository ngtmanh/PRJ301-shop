<%-- 
    Document   : comment
    Created on : Mar 12, 2024, 9:32:20 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Styling for container */
.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 0 20px;
}

/* Styling for comment section */
.comment-top {
    border-radius: 5px;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.commented-section {
    border-radius: 5px;
    box-shadow: 0 1px 2px rgba(0, 0, 0, 0.1);
    padding: 10px;
    margin-top: 15px;
}

/* Styling for profile image */
.profile-image img {
    border-radius: 50%;
}

/* Styling for voting icons */
.voting-icons {
    align-items: center;
}

.voting-icons i {
    cursor: pointer;
}

/* Styling for reply section */
.reply-section {
    display: flex;
    align-items: center;
    margin-top: 5px;
}

.reply-section h6 {
    margin-left: 5px;
    cursor: pointer;
}

/* Styling for comment input section */
.add-comment-section {
    align-items: center;
}

.add-comment-section input {
    flex-grow: 1;
    border-radius: 20px;
}

.add-comment-section button {
    border-radius: 20px;
    margin-left: 10px;
}
</style>


<div class="container mt-5 mb-5">
        <div class="d-flex justify-content-center row">
            <div class="d-flex flex-column col-md-8">
                <div class="d-flex flex-row align-items-center text-left comment-top p-2 bg-white border-bottom px-4">
                    <div class="profile-image"><img class="rounded-circle" src="https://i.imgur.com/t9toMAQ.jpg" width="70"></div>
                    <div class="d-flex flex-column-reverse flex-grow-0 align-items-center votings ml-1"><i class="fa fa-sort-up fa-2x hit-voting"></i><span>127</span><i class="fa fa-sort-down fa-2x hit-voting"></i></div>
                    <div class="d-flex flex-column ml-3">
                        <div class="d-flex flex-row post-title">
                            <h5>Is sketch 3.9.1 stable?</h5><span class="ml-2">(Jesshead)</span></div>
                        <div class="d-flex flex-row align-items-center align-content-center post-title"><span class="bdge mr-1">video</span><span class="mr-2 comments">13 comments&nbsp;</span><span class="mr-2 dot"></span><span>6 hours ago</span></div>
                    </div>
                </div>
                <div class="coment-bottom bg-white p-2 px-4">
                    <div class="d-flex flex-row add-comment-section mt-4 mb-4"><img class="img-fluid img-responsive rounded-circle mr-2" src="https://i.imgur.com/qdiP4DB.jpg" width="38"><input type="text" class="form-control mr-3" placeholder="Add comment"><button class="btn btn-primary" type="button">Comment</button></div>
                    <div
                        class="commented-section mt-2">
                        <div class="d-flex flex-row align-items-center commented-user">
                            <h5 class="mr-2">Corey oates</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">4 hours ago</span></div>
                        <div class="comment-text-sm"><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</span></div>
                        <div
                            class="reply-section">
                            <div class="d-flex flex-row align-items-center voting-icons"><i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span class="ml-2">10</span><span class="dot ml-2"></span>
                                <h6 class="ml-2 mt-1">Reply</h6>
                            </div>
                </div>
            </div>
            <div class="commented-section mt-2">
                <div class="d-flex flex-row align-items-center commented-user">
                    <h5 class="mr-2">Samoya Johns</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">5 hours ago</span></div>
                <div class="comment-text-sm"><span>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua..</span></div>
                <div class="reply-section">
                    <div class="d-flex flex-row align-items-center voting-icons"><i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span class="ml-2">15</span><span class="dot ml-2"></span>
                        <h6 class="ml-2 mt-1">Reply</h6>
                    </div>
                </div>
            </div>
            <div class="commented-section mt-2">
                <div class="d-flex flex-row align-items-center commented-user">
                    <h5 class="mr-2">Makhaya andrew</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">10 hours ago</span></div>
                <div class="comment-text-sm"><span>Nunc sed id semper risus in hendrerit gravida rutrum. Non odio euismod lacinia at quis risus sed. Commodo ullamcorper a lacus vestibulum sed arcu non odio euismod. Enim facilisis gravida neque convallis a. In mollis nunc sed id. Adipiscing elit pellentesque habitant morbi tristique senectus et netus. Ultrices mi tempus imperdiet nulla malesuada pellentesque.</span></div>
                <div
                    class="reply-section">
                    <div class="d-flex flex-row align-items-center voting-icons"><i class="fa fa-sort-up fa-2x mt-3 hit-voting"></i><i class="fa fa-sort-down fa-2x mb-3 hit-voting"></i><span class="ml-2">25</span><span class="dot ml-2"></span>
                        <h6 class="ml-2 mt-1">Reply</h6>
                    </div>
            </div>
        </div>
    </div>
    </div>
    </div>
    </div>
