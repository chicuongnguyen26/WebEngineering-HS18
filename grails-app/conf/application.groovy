// For any URL NOT defined as static rule
// grails.plugin.springsecurity.rejectIfNoRule = false
// grails.plugin.springsecurity.fii.rejectPublicInvocations = false

// For basic authentication
// grails.plugin.springsecurity.useBasicAuth = true
// grails.plugin.springsecurity.basic.realmName = "HTTP Basic Auth Demo"

// For logout functionality
grails.plugin.springsecurity.logout.postOnly = false
grails.plugin.springsecurity.logout.afterLogoutUrl = "/"

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'mvc.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'mvc.UserRole'
grails.plugin.springsecurity.authority.className = 'mvc.Role'

final statics = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/dbconsole/**', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.controllerAnnotations.staticRules = statics

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/dbconsole/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

// config types are 'Annotation', 'Requestmap', or 'InterceptUrlMap'
// grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
// grails.plugin.springsecurity.interceptUrlMap = statics + [
//         [pattern: "/login/auth", access: ["permitAll"]],
//         [pattern: "/person/**", access: ['ROLE_ADMIN']],
//         [pattern: "/**", access: ['ROLE_ADMIN', 'ROLE_GUEST']],
// ]
