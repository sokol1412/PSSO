myApp.factory('Labirynt', function(Kolejka, Pole) {
    //private variables

    function Labirynt() {
        this.mapa = [];
        for (var i = 0; i < 10; i++) {
            var rzad = [];
            var tr = document.createElement("tr");
            for (var j = 0; j < 10; j++) {
                var td = document.createElement("td");
                td.setAttribute("id", i + "_" + j);

                if (Math.floor(Math.random() * 100) + 1 > 80) {
                    if (!(j === 0 && i === 0) && !(j == 9 && i == 9)) {
                        td.appendChild(document.createTextNode("#"));
                        td.style.color = "black";
                        rzad.push("#");
                    } else {
                        rzad.push(" ");
                        td.appendChild(document.createTextNode("O"));
                        td.style.color = "white";
                    }

                } else {
                    rzad.push(" ");
                    td.appendChild(document.createTextNode("O"));
                    td.style.color = "white";
                }
                tr.appendChild(td);
            }
            this.mapa.push(rzad);
            var labirynt = document.getElementById("labirynt").appendChild(tr);
            labirynt.height = 300;
        }
    }

    Labirynt.prototype.rozwiazLabirynt = function() {
        nieSprawdzone = new Kolejka();
        ryswanie = [];

        nieSprawdzone.pushBack(new Pole(0, 0, []));

        while (true) {
            var kratka = nieSprawdzone.pop();
            console.log(kratka);
            if (kratka.x == 9 && kratka.y == 9) {
                alert("labirynt rozwiazany");
                for (var i = 0; i < kratka.droga.length; i++) {
                    var k = kratka.droga[i];
                    document.getElementById(k.x + "_" + k.y).style.color = "black";
                }
                document.getElementById("9_9").style.color = "black";
                break;
            }
            s = kratka.droga;
            s.push(kratka);

            this.mapa[kratka.x][kratka.y] = "A";

            var nowaKratka = null;
            if (kratka.x < 9) //dol
            {
                if (this.mapa[(kratka.x + 1)][kratka.y] == " ") {
                    nowaKratka = new Pole(kratka.x + 1, kratka.y, s);
                    nieSprawdzone.pushBack(nowaKratka);
                    //this.mapa[kratka.x + 1][kratka.y] = "~"                        
                }
            }
            if (kratka.y < 9) //prawo
            {
                if (this.mapa[kratka.x][(kratka.y + 1)] == " ") {
                    nowaKratka = new Pole(kratka.x, kratka.y + 1, s);
                    nieSprawdzone.pushBack(nowaKratka);
                }
            }
            if (kratka.x > 1) //gora
            {
                if (this.mapa[(kratka.x - 1)][kratka.y] == " ") {
                    nowaKratka = new Pole(kratka.x - 1, kratka.y, s);
                    nieSprawdzone.pushBack(nowaKratka);
                    //this.mapa[kratka.x + 1][kratka.y] = "~"                        
                }
            }
            if (kratka.y > 1) //lewo
            {
                if (this.mapa[kratka.x][(kratka.y - 1)] == " ") {
                    nowaKratka = new Pole(kratka.x, kratka.y - 1, s);
                    nieSprawdzone.pushBack(nowaKratka);
                }
            }
        }
    };

    return Labirynt;
});