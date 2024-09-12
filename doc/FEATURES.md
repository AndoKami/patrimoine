# Spécifier

Un [patrimoine](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/Patrimoine.java) (économique,
c'est-à-dire évaluable dans [une devise](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/Devise.java)),
est composé de plusieurs types de [possessions](https://github.com/hei-school/patrimoine/tree/main/src/main/java/school/hei/patrimoine/modele/possession).
Ces possessions peuvent être groupées en 3 grands [agrégats](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/possession/TypeAgregat.java) :
- 💵 **La trésorerie**. C'est l'[argent](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/possession/Argent.java) disponible immédiatement.
  Ici vont l'épargne, les comptes courants, les espèces.
- 🏠 **Les immobilisations**. Ce sont les possessions [matérielles](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/possession/Materiel.java)
  comme une maison, ou immatérielles comme un logiciel, qui ont bien une valeur économique mais qui ne sont pas convertibles facilement en argent.
  De fait, elles ne sont pas aussi facile à exploiter que la trésorie. Par exemple, il faut encore les vendre, les louer ou les mettre en hypothèque pour en tirer profit.
- 🗞️ **Les obligations**. C'est ce que vous devez aux autres ou [dettes](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/possession/Dette.java),
  ainsi que ce que les autres vous doivent ou [créances](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/possession/Creance.java).

[Voici](https://owncloud.hei.school/s/VzAvh2EEr34BAJC) le sujet d'exercice initial pour lequel la librairie a été créée chez [HEI](https://hei.school),
et sur lequel vous pouvez vous entraîner à spécifier.
[Voici](https://owncloud.hei.school/s/SiVASYtItCESdRp) l'examen qui a suivi, ainsi que sa spécification [corrigée](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/cas/zety/PatrimoineZetyAu3Juillet2024.java).

👷‍♂️⚒️ Une interface web est en cours de développement afin de permettre de spécifier sans coder en Java.

# Projeter

Un grapheur permet de générer sous forme de graphe l'évolution du patrimoine sur une période de temps donnée.
Le graphe est configurable :
- il peut afficher [la trésorerie uniquement](https://github.com/hei-school/patrimoine/blob/main/src/test/resources/patrimoine-cresus-sur-quelques-annees_treso.png),
- ou [les immobilisations uniquement](https://github.com/hei-school/patrimoine/blob/main/src/test/resources/patrimoine-cresus-sur-quelques-annees_immo.png),
- ou [les obligations uniquement](https://github.com/hei-school/patrimoine/blob/main/src/test/resources/patrimoine-cresus-sur-quelques-annees_obli.png),
- ou [n'importe quelle combinaison](https://github.com/hei-school/patrimoine/blob/main/src/test/resources/patrimoine-cresus-sur-quelques-annees.png) d'entre eux.

Un [visualiseur Swing](https://github.com/hei-school/patrimoine/blob/ihm/src/main/java/school/hei/patrimoine/visualisation/swing/ihm/VisualiseurCas.java),
sur la branch [ihm](https://github.com/hei-school/patrimoine/tree/ihm), permet de visualiser facilement les projections d'une spécification donnée.

![](https://github.com/hei-school/patrimoine/blob/main/doc/ihm-swing.png)

👷‍♂️⚒️  Un visualiseur de projections sera intégré à l'interface web en cours développement.

# Recouper

Les [flux journaliers](https://github.com/hei-school/patrimoine/blob/main/src/main/java/school/hei/patrimoine/modele/evolution/FluxJournalier.java)
sont la liste des opérations qui se sont déroulées depuis la date de la spécification **jusqu'à aujourd'hui (`LocalDate.now()`)**.

Il faut suivre régulièrement cette liste et mettre à jour la spécification en fonction de quelles opérations se sont réellement réalisées,
et quelles opérations ne se sont jamais réalisées.

Idéalement, dérouler **une politique zéro flux journaliers** :
c'est-à-dire mettre à jour la spécification jusqu'à une date dont la fraîcheur permet d'éliminer tous les flux journaliers listés.

👷‍♂️⚒️ Le visualiseur Swing permet de lister facilement les flux journaliers. Cette fonctionnalité sera portée dans l'interface web en cours de développement.

# Alerter
