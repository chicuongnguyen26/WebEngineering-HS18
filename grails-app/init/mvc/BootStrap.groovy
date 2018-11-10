package mvc

class BootStrap {

    def init = { servletContext ->
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')
        def user = User.findOrSaveWhere(username: 'tst',
                password: 'foo')
        UserRole.create(user, userRole, true)
    }
    def destroy = {
    }
}
