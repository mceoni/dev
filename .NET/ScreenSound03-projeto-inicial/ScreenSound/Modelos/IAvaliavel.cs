using Screensound.Modelos;

namespace ScreenSound.Modelos;

internal interface IAvaliavel
{
    void AdicionarNota(Avaliacao nota);
    double Media { get; }
}
