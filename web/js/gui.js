(function($){

	$.fn.toCsv = function(options){

		var defaults = { title: "Table", delimiter: ';' };
		var opt = $.extend(defaults, options);

		var $table = $(this);

		var $rows = $table.find('tr:has(td)'),
			$headers = $table.find('tr:has(th)'),

			// Temporary delimiter characters unlikely to be typed by keyboard
			// This is to avoid accidentally splitting the actual contents
			tmpColDelim = String.fromCharCode(11), // vertical tab character
			tmpRowDelim = String.fromCharCode(0), // null character

			// actual delimiter characters for CSV format
			colDelim = '"'+opt.delimiter+'"',
			rowDelim = '"\r\n"',

			// Grab headers from table into CSV formatted string
			headers = '"' + $headers.map(function (i, row) {
				var $row = $(row),
					$cols = $row.find('th');

				return $cols.map(function (j, col) {
					var $col = $(col),
						text = $col.text();
					return text.replace('"', '""'); // escape double quotes

				}).get().join(tmpColDelim);
			}).get().join(tmpRowDelim)
				.split(tmpRowDelim).join(rowDelim)
				.split(tmpColDelim).join(colDelim) + '"',

			// Grab text from table into CSV formatted string
			csv = '"' + $rows.map(function (i, row) {
				var $row = $(row),
					$cols = $row.find('td');

				return $cols.map(function (j, col) {
					var $col = $(col),
						text = $col.text();

					var rx=  /(\d+)(\d{3})/;
					text = text.replace('"', '""');
					text = text.replace(".", ",");

					return (text).replace(/(\d)(?=(\d\d\d)+(?!\d))/g, function($1){
						return $1 + "."
					});

				}).get().join(tmpColDelim);

			}).get().join(tmpRowDelim)
				.split(tmpRowDelim).join(rowDelim)
				.split(tmpColDelim).join(colDelim) + '"';

		var tableSection;

		if(!window.navigator.msSaveBlob){
			tableSection = encodeURIComponent(opt.title+'\n');
			tableSection += encodeURIComponent(headers+'\n');
			tableSection += encodeURIComponent(csv+'\n');

			var csvFile = 'data:application/csv;charset=utf-8,' + tableSection;

			window.location.href = csvFile;

		}else{
			tableSection = opt.title+'\n';
			tableSection += headers+'\n';
			tableSection += csv+'\n';

			var csvFile = new Blob([csvContent],{
				type: "application/csv;charset=utf-8;"
			});

			navigator.msSaveBlob(csvFile, opt.title+".csv");
		}

		return this;
	};

	// Listen for the jQuery ready event on the document
	$(function(){
		$('#generate-report').on('click', function(evt){
			evt.preventDefault();
			$('#report').toCsv({
				title: 'Reporte'
			});
		});
	});
}(jQuery));
