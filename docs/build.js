var aglio = require('aglio');

// Render a blueprint with a template by name
var blueprint = '# Some API Blueprint string';
var options = {
    // themeVariables: 'Slate',
    themeVariables: 'Streak',
    themeTemplate: 'triple',
    themeFullWidth: true
};

aglio.renderFile("./index.md", "index.html", options, function (err, warnings) {
    if (err) return console.log(err);
    //if (warnings) console.log(warnings);
});
