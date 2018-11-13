package mvc

class BootStrap {

    def init = { servletContext ->

        def userRole = Role.findOrSaveWhere(authority: Role.USER)
        def adminRole = Role.findOrSaveWhere(authority: Role.ADMIN)

        // Guest
        def user = User.findOrSaveWhere(username: 'guest',
                password: 'guest')
        UserRole.create(user, userRole, true)

        // Admin
        def admin = User.findOrSaveWhere(username: 'admin',
                password: 'adm!n')
        UserRole.create(admin, adminRole, true)
    }
    def destroy = {
    }
}
